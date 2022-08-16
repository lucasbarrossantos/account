package br.com.prismo.account.service.exception;

public class DocumentDuplicatedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DocumentDuplicatedException(String mensagem) {
        super(mensagem);
    }

    public DocumentDuplicatedException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}