
package Modelos;


public class FigurasDoAlbum {
    private Figurinha figura;
    private Integer quantidade;

    public FigurasDoAlbum(Figurinha figura, Integer quantidade) {
        this.figura = figura;
        this.quantidade = quantidade;
    }

    public Figurinha getFigura() {
        return figura;
    }

    public void setFigura(Figurinha figura) {
        this.figura = figura;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Integer consultarQuantidade(Figurinha figura){
        if(figura.equals(this.figura)){
            return this.quantidade;
        }
        return -1;
    }
}
