package pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.response;

import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDto;

import java.util.List;

public record FindCarsResponsive(String code,
                                 String error,
                                 List<CarDto> cars) {
}
