package service;

import dao.OdontologoiDAOH2;
import model.Odontologo;
import dao.iDao;
import java.util.List;
public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(){
        odontologoiDao = new OdontologoiDAOH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    };

    public Odontologo buscarOdontologo(Integer id){
        return odontologoiDao.buscarPorID(id);
    };

    public List<Odontologo> buscarTodos(){
        return odontologoiDao.buscarTodos();
    }

}
