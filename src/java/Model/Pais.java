package Model;

import Config.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Pais {
    private int idPais;
    private String siglas;
    private String capital;
    private int cantHabitantes;
    private double extenTerritorio;
    private String idioma;
    private String moneda;
    Connect con = new Connect();
    
    public Pais() {
    }

    public Pais(int idPais, String siglas, String capital, int cantHabitantes, double extenTerritorio, String idioma, String moneda) {
        this.idPais = idPais;
        this.siglas = siglas;
        this.capital = capital;
        this.cantHabitantes = cantHabitantes;
        this.extenTerritorio = extenTerritorio;
        this.idioma = idioma;
        this.moneda = moneda;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getCantHabitantes() {
        return cantHabitantes;
    }

    public void setCantHabitantes(int cantHabitantes) {
        this.cantHabitantes = cantHabitantes;
    }

    public double getExtenTerritorio() {
        return extenTerritorio;
    }

    public void setExtenTerritorio(double extenTerritorio) {
        this.extenTerritorio = extenTerritorio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public ArrayList<Pais> ListarPais() {
        ArrayList<Pais> list = new ArrayList<Pais>();
        String sql = "select * from pais;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pais pa = new Pais();
                pa.setIdPais(rs.getInt(1));
                pa.setSiglas(rs.getString(2));
                pa.setCapital(rs.getString(3));
                pa.setCantHabitantes(Integer.parseInt(rs.getString(4)));
                pa.setExtenTerritorio(Double.parseDouble(rs.getString(5)));
                pa.setIdioma(rs.getString(6));
                pa.setMoneda(rs.getString(7));
                list.add(pa);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.Desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }
    public void AddPais(Pais pa) {
        String sql = "insert into pais (siglas, capital, cantHabitantes, extenTerritorio, idioma, moneda) "
                + "VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, pa.getSiglas());
            ps.setString(2, pa.getCapital());
            ps.setInt(3, pa.getCantHabitantes());
            ps.setDouble(4, pa.getExtenTerritorio());
            ps.setString(5, pa.getIdioma());
            ps.setString(6, pa.getMoneda());
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
    public void UpdatePais(Pais pa) {
        String sql = "update pais set siglas = ?, capital = ?, cantHabitantes = ?, extenTerritorio = ?,"
                + "idioma = ?, moneda = ? where idPais = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, pa.getSiglas());
            ps.setString(2, pa.getCapital());
            ps.setInt(3, pa.getCantHabitantes());
            ps.setDouble(4, pa.getExtenTerritorio());
            ps.setString(5, pa.getIdioma());
            ps.setString(6, pa.getMoneda());
            ps.setInt(7, pa.getIdPais());
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
    public void DeletePais(int idPais) {
        String sql = "DELETE FROM pais WHERE idPais = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, idPais);
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
}
