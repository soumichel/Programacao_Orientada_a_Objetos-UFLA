package feed;

import java.util.NoSuchElementException;

public class MensagemNaoEncontradaException extends NoSuchElementException {
    private int id;

    public MensagemNaoEncontradaException(int id) {
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
}
