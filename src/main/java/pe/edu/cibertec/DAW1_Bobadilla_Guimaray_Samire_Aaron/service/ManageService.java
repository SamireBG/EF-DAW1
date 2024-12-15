package pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.service;

import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDetailDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarUpdateDto carUpdateDto) throws Exception;
}
