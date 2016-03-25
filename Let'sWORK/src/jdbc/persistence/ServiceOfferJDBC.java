package jdbc.persistence;

import java.sql.*;
import java.util.*;

import jdbc.DataBaseConnection;

import persistence.ServiceOffer;

import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class ServiceOfferJDBC extends ServiceOffer {

    private long id;

    // Constructeurs
    public ServiceOfferJDBC(double price) {
        super(price);
        this.id = -1;
    }

//    public ServiceOfferJDBC() {
//        super();
//        this.id = -1;
//    }

//    public void load(String username) throws LoadException {
//        try {
//            Connection connection = DataBaseConnection.getConnection();
//            // Preparation for the query
//            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.user WHERE username = ?;");
//            // Indication about the value of the username in the WHERE
//            prepare.setString(1, username);
//            // Execution of the query
//            ResultSet result = prepare.executeQuery();
//            // we don't use a while here bcs we know username is unique
//            if (result.next()) {
//                // We get the username and the password and the database
//                this.setId(result.getLong("id"));
//                this.setUsername(result.getString("username"));
//                this.setPassword(result.getString("password"));
//            } else {
//                // If there is no result : Exception
//                throw new LoadException("Can't load User with the username : " + username);
//            }
//
//            // load admin
//            AdminJDBC admin = new AdminJDBC();
//            try {
//                admin.load(this.getId());
//                this.addRole(admin);
//            } catch (LoadException e) {
//            }
//
//            // load person
//            PersonInfoJDBC personInfo = new PersonInfoJDBC();
//            try {
//                personInfo.load(this.getId());
//
//                // load customer
//                CustomerJDBC customer = new CustomerJDBC();
//                try {
//                    customer.load(this.getId());
//                    this.addRole(customer);
//                    customer.setPersonInfo(personInfo);
//                } catch (LoadException e) {
//                }
//
//                // load seller
//                SellerJDBC seller = new SellerJDBC();
//                try {
//                    seller.load(this.getId());
//                    this.addRole(seller);
//                    seller.setPersonInfo(personInfo);
//                } catch (LoadException e) {
//                }
//            } catch (LoadException e) {
//            }
//
//        } catch (SQLException e) {
//            throw new LoadException("Can't load User with the username : " + username);
//        }
//    }

//    @Override
//    public void save() throws SaveException {
//        try {
//            Connection connection = DataBaseConnection.getConnection();
//            // Preparation for the query
//            PreparedStatement prepare = connection.prepareStatement(
//                    "INSERT INTO public.user (id, username, password) VALUES(DEFAULT, ?, ?) RETURNING id;");
//            // Indication about the value of the username in the WHERE
//            prepare.setString(1, this.getUsername());
//            prepare.setString(2, this.getPassword());
//            // Execution of the query
//            ResultSet result = prepare.executeQuery();
//            // we don't use a while here bcs we know username is unique
//            if (result.next()) {
//                // We get the username and the password and the database
//                this.setId(result.getLong("id"));
//            } else {
//                // If there is no result : Exception
//                throw new SaveException("An error");
//            }
//
//            for (UserRole role : this.getRoles()) {
//                try {
//                    role.save();
//                } catch (SaveException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (SQLException e) {
//            throw new SaveException("An error");
//        }
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof UserJDBC && this.id >= 0) {
//            return this.id == ((UserJDBC) o).id;
//        } else {
//            return false;
//        }
//    }

    protected long getId() {
        return this.id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}