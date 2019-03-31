/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.ConMySQL;
import Config.Connect;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tecnologia
 */
public class DB {

    ConMySQL con = new ConMySQL();
    Connect con_ = new Connect();
    
    public void CreaDB() {
        String sql = "create database country;";
        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);

            ps.executeUpdate();
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.Desconectar();
            } catch (Exception ex) {
            }
        }
    }
    
        public void CreaTable() {
            
        String sql_ = "create table pais(idPais int(10) not null PRIMARY KEY AUTO_INCREMENT, siglas char(3) not null, capital varchar(30) not null, cantHabitantes int(10) not null, extenTerritorio decimal(10,2) not null, idioma varchar(30) not null, moneda varchar(30) not null);";
          
        PreparedStatement ps = null;
        try {
            ps = con_.getConnection().prepareStatement(sql_);

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con_.Desconectar();
            } catch (Exception ex) {
            }
        }
    }
}
