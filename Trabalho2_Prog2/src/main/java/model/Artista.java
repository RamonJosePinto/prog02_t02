package model;

import dao.AlbumDAO;
import dao.ReviewDAO;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Artista extends Pessoa {

    public Artista(String username, String email, String senha, String nome) {
        super(username, email, senha, nome, TipoPessoa.ARTISTA);
    }

    public Artista(int id, String username, String email, String senha, String nome) {
        super(id, username, email, senha, nome, TipoPessoa.ARTISTA);
    }

    public Artista(String username, String email, String senha, String nome, Path pathImagemPerfil) {
        super(username, email, senha, nome, TipoPessoa.ARTISTA, pathImagemPerfil);
    }

    public boolean cadastrarAlbum(Album album) {
        // gravar em banco de dados
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Album> getAlbuns() {
        AlbumDAO daoAlbum = new AlbumDAO();
        return daoAlbum.getAlbunsArtista(idPessoa);
    }

    public int calcularScore() {
        AlbumDAO daoAlbum = new AlbumDAO();
        ReviewDAO daoReview = new ReviewDAO();
        List<Album> albunsArtista = daoAlbum.getAlbunsArtista(this.idPessoa);
        float somaScore = 0;
        float contReviews = 0;

        for (Album a : albunsArtista) {
            List<Review> reviewsAlbum = daoReview.getReviewsAlbum(a.getIdAlbum());

            System.out.println(a.toString());

            for (Review r : reviewsAlbum) {
                System.out.println(r.toString());
                somaScore += r.getNota();
                contReviews++;
            }
        }
        System.out.println(somaScore);
        System.out.println(contReviews);

        return (int) Math.round(somaScore / contReviews);

    }

    @Override
    public int contarReviews() {
        AlbumDAO daoAlbum = new AlbumDAO();
        ReviewDAO daoReview = new ReviewDAO();
        List<Album> albunsArtista = daoAlbum.getAlbunsArtista(this.idPessoa);
        int contReviews = 0;

        for (Album album : albunsArtista) {
            List<Review> reviewsAlbum = daoReview.getReviewsAlbum(album.getIdAlbum());
            contReviews += reviewsAlbum.size();
        }

        return contReviews;
    }

//    @Override
//    public boolean login(String email, String senha) {
//        for (Artista a : artistas) {
//            if (a.getEmail().equals(email) && a.getSenha().equals(senha)) {
//                Pessoa.setUsuarioLogado(a);
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void carregarArtistas() {
//        Artista a1 = new Artista("joao123", "joao123@email.com", "12345", "João Silva");
//        Artista a2 = new Artista("maria456", "maria456@email.com", "67890", "Maria Souza");
//        Artista a3 = new Artista("pedro789", "pedro789@email.com", "24680", "Pedro Ferreira");
//        Artista a4 = new Artista("ana456", "ana456@email.com", "13579", "Ana Clara");
//        Artista a5 = new Artista("carlos123", "carlos123@email.com", "98765", "Carlos Santos");
//
//        ArtistaDAO aDAO = new ArtistaDAO();
//        aDAO.salvarArtistas(a1);
//        aDAO.salvarArtistas(a2);
//        aDAO.salvarArtistas(a3);
//        aDAO.salvarArtistas(a4);
//        aDAO.salvarArtistas(a5);
//
//        System.out.println(aDAO.artistas);
//    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Artista{" + super.toString() + '}';
    }

}
