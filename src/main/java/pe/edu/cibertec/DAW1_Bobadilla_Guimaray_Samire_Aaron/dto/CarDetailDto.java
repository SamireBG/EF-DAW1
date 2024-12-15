package pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto;

import java.util.Date;

public record CarDetailDto(Integer carId,
                           String make,
                           String model,
                           Integer year,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,
                           Integer mileage,
                           String engineType,
                           String color,
                           String insuranceCompany,
                           Date registrationExpirationDate) {
}
