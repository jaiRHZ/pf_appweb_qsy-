package dto;

import java.io.Serializable;
import web.blogdominio.domain.Anclada;

@lombok.Data
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class AncladaDto implements Serializable{

    private String admininstrador;
    private String titulo;
    private String contenido;
    private String fechaHoraCreacion;
    private String url;

    public static AncladaDto createAncladaDto(Anclada anclada) {
        return new AncladaDto().builder().admininstrador(anclada.getAdministrador().getNombreCompleto()).
                titulo(anclada.getTitulo())
                .contenido(anclada.getContenido()).
                fechaHoraCreacion(anclada.getFechaHoraCreacion().toString()).
                url(anclada.getUrl()).
                build();
    }
}
