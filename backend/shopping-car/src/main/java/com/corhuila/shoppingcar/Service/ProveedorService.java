package com.corhuila.shoppingcar.Service;


import com.corhuila.shoppingcar.Document.Cliente;
import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IRepository.IProveedorRepository;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService  extends IProveedorService {
    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private IProveedorRepository repository;

    @Override
    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public void update(Proveedor proveedor, String id) {
    //Obtener el objeto cliente y el id
    //Verificar con el id, si exiten los datos
    Optional<Proveedor> pv = repository.findById(id);

    //Cargar nuevo objeto
        if(!pv.isEmpty())

    {
        Proveedor proveedorUpdate = pv.get();
        proveedorUpdate.setCodigo(proveedor.getCodigo());
        proveedorUpdate.setNombre(proveedor.getNombre());
        proveedorUpdate.setDireccion(proveedor.getDireccion());

        //Actualizar el objeto cliente
        repository.save(proveedorUpdate);
    } else

    {
        System.out.println("No existe el cliente");
    }

}

    @Override
    public void deleteLogical(Proveedor proveedor, String id) {
        //Obtener el objeto cliente y el id
        //Verificar con el id, si exiten los datos
        Optional<Proveedor> pv = repository.findById(id);

        //Cargar nuevo objeto
        if (!pv.isEmpty()){
            Proveedor proveedorUpdate = pv.get();
            //Reportar fecha de eliminación
            //clienteUpdate.setNombre(cliente.getNombre());
            //Actualizar el objeto cliente
            repository.save(proveedorUpdate);
        }else{
            System.out.println("No existe el cliente");
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}


