package pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDetailDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.dto.CarUpdateDto;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.entity.Car;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.repository.CarRepository;
import pe.edu.cibertec.DAW1_Bobadilla_Guimaray_Samire_Aaron.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getOwnerName()));
        });
        return cars;

    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getRegistrationExpirationDate()));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setOwnerName(carDto.ownerName());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarUpdateDto carUpdateDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        if(optional.isPresent())
        return false;
        else {
            Car car = new Car();
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setVin(carUpdateDto.vin());
            car.setLicensePlate(carUpdateDto.licensePlate());
            car.setOwnerName(carUpdateDto.ownerName());
            car.setOwnerContact(carUpdateDto.ownerContact());
            car.setPurchaseDate(carUpdateDto.purchaseDate());
            car.setMileage(carUpdateDto.mileage());
            car.setEngineType(carUpdateDto.engineType());
            car.setColor(carUpdateDto.color());
            car.setInsuranceCompany(carUpdateDto.insuranceCompany());
            car.setInsurancePolicyNumber(carUpdateDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carUpdateDto.registrationExpirationDate());
            car.setServiceDueDate(carUpdateDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }

    }
}
