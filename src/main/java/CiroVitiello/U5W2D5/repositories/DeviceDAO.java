package CiroVitiello.U5W2D5.repositories;

import CiroVitiello.U5W2D5.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDAO extends JpaRepository<Device, Long> {
}
