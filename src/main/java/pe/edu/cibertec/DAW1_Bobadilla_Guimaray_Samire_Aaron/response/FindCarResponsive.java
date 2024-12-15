package pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.response;

import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDetailDto;

public record FindCarResponsive(String code,
                                String error,
                                CarDetailDto carDetailDto) {
}
