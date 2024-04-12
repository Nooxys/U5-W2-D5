package CiroVitiello.U5W2D5.controllers;

import CiroVitiello.U5W2D5.entities.Device;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @GetMapping
    private Page<Device> getAllDevices(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String sortBy) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Device saveDevice(@RequestBody Device body) {

    }

    @GetMapping("/{deviceId}")
    private Device findDeviceById(@PathVariable int deviceId) {

    }

    @PutMapping("/{deviceId}")
    private Device findDeviceByIdAndUpdate(@PathVariable int deviceId, @RequestBody Device body) {

    }

    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findDeviceByIdAndDelete(@PathVariable int deviceId) {

    }
    
}