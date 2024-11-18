import java.util.Scanner;
public class App {
public static void main(String[] args) {
Album novoAlbum = new Album();

Artista primeiroArtista = new Artista("Matue", "trap");
Artista segundoArtista = new Artista("Mc Kevin", "Funk");
novoAlbum.addDisco(new Disco("Gorila roxo", 2020, primeiroArtista));
novoAlbum.addDisco(new Disco("Cavalo de troia", 2019, segundoArtista));

System.out.println("Álbum Disponível:");
novoAlbum.ExibirAlbum();

Scanner scanner = new Scanner(System.in);
boolean continuar = true;

try {
    while (continuar) {
        System.out.println("\nOpções:");
        System.out.println("1 - Cadastrar disco novo");
        System.out.println("2 - Cadastrar artista novo e associar a um disco ja existente");
        System.out.println("3 - Mostrar álbum");
        System.out.println("4 - Remover disco");
        System.out.println("5 - Editar disco");
        System.out.println("6 - Encerrar");

        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

    switch (opcao) {
        case 1: cadastrarDisco(novoAlbum, scanner); break;
        case 2: cadastrarArtistaAssociado(novoAlbum, scanner); break;
        case 3: ExibirAlbum(novoAlbum); break;
        case 4: removerDisco(novoAlbum, scanner); break;
        case 5: editarDisco(novoAlbum, scanner); break;
        case 6: continuar = false; System.out.println("Encerrado!"); break;
        default: System.out.println("Opção não disponível, tente novamente.");
    }
  }
} catch (Exception erro) {
    System.out.println("Algo de inesperado aconteceu na validação de sua resposta!");
} finally {
        scanner.close();
   }
}
private static void ExibirAlbum(Album novoAlbum) {
    if (novoAlbum.getFaixasDoAlbum().isEmpty()) {
         System.out.println("Nenhum disco cadastrado!");
    } else {
        novoAlbum.ExibirAlbum();
    }
}
private static Disco buscarDiscoPorTitulo(Album novoAlbum, String titulo) {
    for (Disco disco :novoAlbum.getFaixasDoAlbum()) {
         if (disco.getTitulo().equalsIgnoreCase(titulo)) {
            return disco;
        }
    }
    return null;
}
private static void cadastrarDisco(Album novoAlbum, Scanner scanner) {
    System.out.print("Título do disco: ");
    String titulo = scanner.nextLine();

    System.out.print("Nome do artista: ");
    String nomeArtista = scanner.nextLine();

    System.out.print("Gênero musical do artista: ");
    String genero = scanner.nextLine();

    System.out.print("Ano de lançamento: ");
    int ano = scanner.nextInt();
    scanner.nextLine();

    Artista artista = new Artista(nomeArtista, genero);
    Disco disco = new Disco(titulo, ano, artista);

    novoAlbum.addDisco(disco);
    System.out.println("Disco cadastrado!");
}
private static void cadastrarArtistaAssociado(Album novoAlbum, Scanner scanner) {
    if (novoAlbum.getFaixasDoAlbum().isEmpty()) {
        System.out.println("Nenhum disco cadastrado");
        return;
    }

    System.out.println("Esses são os discos disponíveis:");
    novoAlbum.ExibirAlbum();

    System.out.print("Digite o título do disco para associar ao novo artista: ");
    String tituloDisco = scanner.nextLine();

    Disco disco = buscarDiscoPorTitulo(novoAlbum, tituloDisco);
    if (disco == null) {
        System.out.println("Disco não encontrado.");
        return;
    }

    System.out.print("Nome do novo artista: ");
    String nomeArtista = scanner.nextLine();

    System.out.print("Gênero musical do novo artista: ");
    String genero = scanner.nextLine();

    Artista novoArtista = new Artista(nomeArtista, genero);
    disco.setArtista(novoArtista);

    System.out.println("Novo artista associado ao disco!");
}
private static void removerDisco(Album novoAlbum, Scanner scanner) {
    if (novoAlbum.getFaixasDoAlbum().isEmpty()) {
        System.out.println("Nenhum disco cadastrado.");
        return;
    }

    System.out.println("Esses são os discos disponíveis:");
    novoAlbum.ExibirAlbum() ;

    System.out.print("Título do disco que deseja remover: ");
    String tituloDisco = scanner.nextLine();

    Disco disco = buscarDiscoPorTitulo(novoAlbum, tituloDisco);
    if (disco == null) {
        System.out.println("Disco não encontrado.");
         return;
    }

    novoAlbum.removeDisco(disco);
    System.out.println("Disco removido!");
}
private static void editarDisco(Album novoAlbum, Scanner scanner) {
    if (novoAlbum.getFaixasDoAlbum().isEmpty()) {
        System.out.println("Nenhum disco cadastrado");
        return;
    }

    System.out.println("Esses são os discos disponíveis:");
    novoAlbum.ExibirAlbum();

    System.out.print("Título do disco que deseja editar: ");
    String tituloDisco = scanner.nextLine();

    Disco disco = buscarDiscoPorTitulo(novoAlbum, tituloDisco);
    if (disco == null) {
        System.out.println("Disco não encontrado.");
        return;
    }

    System.out.println("\nEscolha uma opção para editar:");
    System.out.println("1 - Nome do disco");
    System.out.println("2 - Nome do artista");
    System.out.println("3 - Gênero");
    System.out.println("4 - Ano de lançamento");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();
    scanner.nextLine();

    switch (opcao) {
        case 1: 
            System.out.print("Novo título: ");
            String tituloNovo = scanner.nextLine();
            disco.setTitulo(tituloNovo);
            System.out.println("Nome do disco editado!");
            break;
        case 2:
            System.out.print("Novo artista: ");
            String artistNovo = scanner.nextLine();
            disco.getArtista().setNome(artistNovo);
            System.out.println("Nome do artista editado!");
            break;
        case 3:
            System.out.print("Novo gênero: ");
            String generoNovo = scanner.nextLine();
            disco.getArtista().setGenero(generoNovo);
            System.out.println("Gênero musical editado!");
            break;
        case 4:
            System.out.print("Novo ano de lançamento: ");
            int novoAnoL = scanner.nextInt();
            disco.setAnoLancamento(novoAnoL);
            System.out.println("Ano de lançamento editado!");
            break;
        default:
        System.out.println("Opção inválida.");
    }
  }
}
//Atividade Ithallo Emanuel - "Trabalho catálogo de discos"