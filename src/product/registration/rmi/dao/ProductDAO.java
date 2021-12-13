package product.registration.rmi.dao;

import product.registration.rmi.connection.ConnectionManager;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import product.registration.rmi.model.Product;

/**
 * @author roberlan-carvalho
 */
public class ProductDAO {

    private static Connection connection;

    public Product add(Product product) throws RemoteException {
        try {
            connection = ConnectionManager.getConnection();
            String sql = "INSERT INTO product(name, description, price)"
                    + "VALUES(?,?,?);";
            
            PreparedStatement statement = Objects.requireNonNull(connection).prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());

            if (statement.executeUpdate() > 0) {
                product.setId(getId());                    
            }
            statement.close();
            connection.close();
            
            return product;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ADD ERR > "+e.getMessage());
        }
        
        return null;
    }

    public boolean alter(Product product) throws RemoteException {
        try {
            connection = ConnectionManager.getConnection();
            String sql = "UPDATE product SET name = ?, description = ?, price = ? WHERE id = ?";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getId());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALTER ERR > "+e.getMessage());
        }
        return false;
    }

    public boolean remmove(int productId) throws RemoteException {
        try {
            connection = ConnectionManager.getConnection();
            String sql = "DELETE FROM product WHERE id = ?";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "REMOVE ERR > "+e.getMessage());
        }
        return false;
    }

    public Product select(int productId) {
        Product product = null;

        try {
            connection = ConnectionManager.getConnection();
            String sql = "SELECT name, description, price FROM product"
                    + "WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                float price = rs.getFloat("price");

                product = new Product(productId, name, description, quantity, price);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ERR > "+e.getMessage());
        }

        return product;
    }

    public List<Product> selectAll() throws RemoteException {
        List<Product> products = new ArrayList<>();

        try {
            connection = ConnectionManager.getConnection();
            String sql = "SELECT id, name, description, price FROM product ORDER BY id;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                float price = rs.getFloat("price");

                Product product = new Product(id, name, description, quantity, price);
                products.add(product);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SELECT ALL ERR > "+e.getMessage());
        }

        return products;
    }
    
    private int getId() throws RemoteException {
        int id = 0;
        try {
            connection = ConnectionManager.getConnection();
            String sql = "SELECT MAX(id) AS id FROM product;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "GET ID ERR > "+e.getMessage());
        }

        return id;
    }

}
