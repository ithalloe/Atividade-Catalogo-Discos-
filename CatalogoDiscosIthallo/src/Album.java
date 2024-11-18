import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Album {
    private List<Disco> faixasDoAlbum;
    private Set<Artista> artistas;

    public Album() {
        this.faixasDoAlbum = new ArrayList<>();
        this.artistas = new HashSet<>();
    }

    public List<Disco> getFaixasDoAlbum() {
        return faixasDoAlbum;
    }
    public void setFaixasDoAlbum(List<Disco> faixasDoAlbum) {
        this.faixasDoAlbum = faixasDoAlbum;
    }
    public void addDisco(Disco disco) {
        faixasDoAlbum.add(disco);
    }
    public void removeDisco(Disco disco) {
        faixasDoAlbum.remove(disco);
    }
    public Set<Artista> getArtistas() {
        return artistas;
    }
    public void addArtista(Artista artista) {
        artistas.add(artista);
    }
    public void removeArtista(Artista artista) {
        artistas.remove(artista);
    }

    public void ExibirAlbum() {
        for (Disco disco : faixasDoAlbum) {
            System.out.println("\nDisco: " + disco.getTitulo()
            + "\nArtista: " + disco.getArtista().getNome()
            + "\nGênero: " + disco.getArtista().getGenero()
            + "\nAno: " + disco.getAnoLancamento());
        }
    }
}
//Atividade Ithallo Emanuel - "Trabalho catálogo de discos"