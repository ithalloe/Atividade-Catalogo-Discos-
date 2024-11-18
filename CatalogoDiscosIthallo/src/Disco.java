public class Disco {
    protected Artista artista;
    protected String titulo;
    protected int anoLancamento;
    
    public Disco(String titulo, int anoLancamento, Artista artista) {
        this.artista = artista;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public Artista getArtista() {
        return artista;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
//Atividade Ithallo Emanuel - "Trabalho catálogo de discos"