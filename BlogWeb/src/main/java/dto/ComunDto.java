package dto;

import java.io.Serializable;
import java.util.ArrayList;
import web.blogdominio.domain.Comun;
import java.util.List;

@lombok.Data
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ComunDto implements Serializable {

    private Long id;
    private String titulo;
    private String contenido;
    private String nombreUsuario;
    private String fechaHoraCreacion;
    private String url;
    private List<ComentarioDto> comentarios;

    public static ComunDto createComunDto(Comun comun) {

        if (comun == null) {
            return null;
        }
        return new ComunDto().builder()
                .id(comun.getId())
                .titulo(comun.getTitulo() != null ? comun.getTitulo() : "Sin título")
                .contenido(comun.getContenido() != null ? comun.getContenido() : "")
                .fechaHoraCreacion(comun.getFechaHoraCreacion() != null ? comun.getFechaHoraCreacion().toString() : "")
                .url(comun.getUrl() != null ? comun.getUrl() : "")
                .comentarios(comun.getComentarios() != null ? ComentarioDto.createComentarioDto(comun.getComentarios()) : new ArrayList<>())
                .nombreUsuario(comun.getUsuario() != null ? comun.getUsuario().getNombreCompleto() : "Usuario desconocido")
                .build();
    }

    public static List<ComunDto> createListComunDto(List<Comun> comunes) {
        List<ComunDto> comuns = new ArrayList<>();
        for (Comun comun : comunes) {
            comuns.add(createComunDto(comun));
        }
        return comuns;
    }
}
