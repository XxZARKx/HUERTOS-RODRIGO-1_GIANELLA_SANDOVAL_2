package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoiDAOH2 implements iDao<Odontologo>{

    private static final Logger logger= Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (ID, NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES(?, ?, ?, ?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Iniciando guardado de odontologo");
        Connection connection = null;

        try{
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(2, odontologo.getNumeroMatricula());
            psInsert.setString(3, odontologo.getNombre());
            psInsert.setString(4, odontologo.getApellido());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while(rs.next()) {
                odontologo.setId(rs.getInt(1));
            }

        }catch (Exception e){
            logger.warn(e.getMessage());
        }

        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {

        logger.info("Iniciando la búsqueda de un odontólogo por id: " + id);
        Connection connection = null;
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1, id);
            ResultSet rs = psSelectOne.executeQuery();
            while(rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                logger.info("Odontólogo obtenido con éxito");
            }
        } catch (Exception e) {
            logger.warn(e.getMessage() + " El odontólogo no se pudo obtener con el id: " + id);
        }
        logger.info("Odontólogo encontrado correctamente: ");
        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("iniciando la busqueda de todos los odontologos");
        Connection connection= null;
        List<Odontologo> listaOdontologo= new ArrayList<>();

        try {
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                listaOdontologo.add(odontologo);
            }
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        logger.info("La lista de odontologos se obtuvo correctamente: " + listaOdontologo);
        return listaOdontologo;
    }
}
