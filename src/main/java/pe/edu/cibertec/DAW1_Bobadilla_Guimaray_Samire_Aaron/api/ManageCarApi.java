package pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDetailDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarUpdateDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.response.*;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponsive findCars(){

        try {
            List<CarDto> cars = manageService.getAllCars();
            if(!cars.isEmpty())
                return new FindCarsResponsive("01",null,cars);
            else
                return new FindCarsResponsive("02","Auto no encontrado",null);

        }catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponsive("99","An error ocurred, please  try again",null);
        }

    }

    @GetMapping("/detail")
    public FindCarResponsive findCar(@RequestParam(value = "id", defaultValue = "0")String id){

        try {
            Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new FindCarResponsive("01",null,car)
            ).orElse(
                new FindCarResponsive("02","Auto no encontrado",null)
            );
        }catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponsive("99","Ocurrió un error, por favor inténtalo nuevamente",null);
        }

    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto){

        try {
            if(manageService.updateCar(carDto))
                return new UpdateCarResponse("01",null);
            else
                return new UpdateCarResponse("02","Auto no encontrado");

        }catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99","Ocurrió un error, por favor inténtalo nuevamente");
        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id){

        try {
            if(manageService.deleteCarById(Integer.parseInt(id)))
                return new DeleteCarResponse("01",null);
            else
                return new DeleteCarResponse("02","Auto no encontrado");

        }catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99","Ocurrió un error, por favor inténtalo nuevamente");
        }

    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarUpdateDto carUpdateDto){

        try {
            if(manageService.addCar(carUpdateDto))
                return new CreateCarResponse("01",null);
            else
                return new CreateCarResponse("02","El auto ya existe");

        }catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99","Ocurrió un error, por favor inténtalo nuevamente");
        }

    }


}
