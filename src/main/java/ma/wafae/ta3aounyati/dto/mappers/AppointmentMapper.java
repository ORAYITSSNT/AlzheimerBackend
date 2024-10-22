package ma.wafae.ta3aounyati.dto.mappers;

import ma.wafae.ta3aounyati.dto.requests.AppointmentRequest;
import ma.wafae.ta3aounyati.dto.responses.AppointmentResponse;
import ma.wafae.ta3aounyati.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);
    Appointment requestToEntity(AppointmentRequest appointmentRequest);
    Appointment responseToEntity(AppointmentResponse appointmentResponse);
    AppointmentResponse entityToResponse(Appointment appointment);
    AppointmentRequest entityToRequest(Appointment appointment);
    List<AppointmentResponse> toDtos(List<Appointment> Appointments);
    List<Appointment> toEntities(List<AppointmentResponse> appointmentResponses);
}
