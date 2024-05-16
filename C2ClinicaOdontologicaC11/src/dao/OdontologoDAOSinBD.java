package dao;

import model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOSinBD implements iDao<Odontologo> {

    private List<Odontologo> odontologos;

    public OdontologoDAOSinBD(List<Odontologo> odontologos) {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getId().equals(id)) {
                return odontologo;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {}

    @Override
    public void eliminar(Integer id){};

    @Override
    public List<Odontologo> buscarTodos() {
        return new ArrayList<>(odontologos);
    };
}
