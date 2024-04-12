package CiroVitiello.U5W2D5.services;

import CiroVitiello.U5W2D5.dto.NewDeviceDTO;
import CiroVitiello.U5W2D5.entities.Device;
import CiroVitiello.U5W2D5.exceptions.NotFoundException;
import CiroVitiello.U5W2D5.repositories.DeviceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceDAO dd;

    @Autowired
    private EmployeeService es;

    public Page<Device> getDevices(int page, int size, String sortBy) {
        if (size > 50) size = 50;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.dd.findAll(pageable);
    }

    public Device save(NewDeviceDTO body) {
        return this.dd.save(new Device(body.typology(), body.status(), es.findById(body.employeeId())));
    }

    public Device findById(long id) {
        return this.dd.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Device findByIdAndUpdate(long id, NewDeviceDTO body) {

        Device found = this.findById(id);

        found.setTypology(body.typology());
        found.setStatus(body.status());
        found.setEmployee(es.findById(body.employeeId()));
        dd.save(found);
        return found;
    }

    public void findByIdAndDelete(long id) {
        Device found = this.findById(id);
        this.dd.delete(found);
    }

}
