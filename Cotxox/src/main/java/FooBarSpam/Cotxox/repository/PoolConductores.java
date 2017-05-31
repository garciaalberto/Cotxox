package FooBarSpam.Cotxox.repository;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PoolConductores implements PoolConductoresRepository {

    private ArrayList<Conductor> conductores = null;

    public PoolConductores() {

    }

    public PoolConductores(ArrayList<Conductor> conductores) {
        this.conductores = conductores;
    }

    public ArrayList<Conductor> getConductores() {
        return this.conductores;
    }

    public Conductor asignarConductor() {
        int indice = elegirConductor();
        getConductores().get(indice).setOcupado(true);
        return getConductores().get(indice);
    }

    // He elegido TheradLocalRandom para dar aleatoriedad a los conductores 
    //y que no vaya cogiendo siempre los del principio de la lista
    private int elegirConductor() {
        int indice = ThreadLocalRandom.current().nextInt(0, getConductores().size());
        while (getConductores().get(indice).isOcupado() == true) {
            indice = ThreadLocalRandom.current().nextInt(0, getConductores().size());
        }
        return indice;
    }

    // Implements CrudRepository
    @Override
    public <S extends PoolConductores> S save(S s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends PoolConductores> Iterable<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PoolConductores findOne(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<PoolConductores> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<PoolConductores> findAll(Iterable<Integer> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(PoolConductores t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends PoolConductores> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
