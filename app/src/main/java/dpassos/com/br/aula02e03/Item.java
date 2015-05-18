package dpassos.com.br.aula02e03;

/**
 * Created by djalma on 15/05/2015.
 */
public class Item {

    private String cabecalho;
    private String detalhes;
    private String imageUrl;

    public Item(String cabecalho, String detalhes, String imageUrl) {
        this.cabecalho = cabecalho;
        this.detalhes = detalhes;
        this.imageUrl = imageUrl;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }
    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
