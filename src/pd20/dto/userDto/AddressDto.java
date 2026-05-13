package pd20.dto.userDto;

public record AddressDto(
        String street,
        String suite,
        String city,
        String zipcode,
        GeoDto geo
) {
}
