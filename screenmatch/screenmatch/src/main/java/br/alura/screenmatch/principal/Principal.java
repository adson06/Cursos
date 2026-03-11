package br.alura.screenmatch.principal;

import br.alura.screenmatch.model.DadosEpisodio;
import br.alura.screenmatch.model.DadosSerie;
import br.alura.screenmatch.model.DadosTemporada;
import br.alura.screenmatch.model.Episodio;
import br.alura.screenmatch.service.ConsumoApi;
import br.alura.screenmatch.service.ConverterDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=d6220ded";



    public void exibeMenu(){
        System.out.println("Digite o nome da série para busca:");
        var nomeSerie = scanner.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();
        for(int i= 1; i<= dadosSerie.totalTemporadas(); i++){
            json = consumo.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=d6220ded");
            DadosTemporada dadostemp = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadostemp);
        }
        temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        temporadas.forEach(System.out::println);

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());


        System.out.println("Top Episodios: \n");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

            episodios.forEach(System.out::println);

        System.out.println("A partir de que  ano voce desejar ver a serie??");
            var ano = scanner.nextLine();
            scanner.nextLine();

        LocalDate databusca = LocalDate.of(Integer.parseInt(ano), 1, 1);
        DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream().filter(e -> e.getDataLancamento() !=null && e.getDataLancamento().isAfter(databusca))
                .forEach(e -> System.out.println(
                        "Temporada" + e.getTemporada() +
                        "Episodio" + e.getNumeroEpisodio() +
                                "Data de Lancamento" + e.getDataLancamento()
                ));
        Map<Integer, Double> avaliacoesporTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0).collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getTemporada)));
        System.out.println(avaliacoesporTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getTemporada));
        System.out.println("Media: " + est.getAverage());
        System.out.println("Soma: " + est.getSum());
        System.out.println("Melhor Episodio: " + est.getMax());
        System.out.println("Pior Episodio: " + est.getMin());
        System.out.println("Quantidade: " + est.getCount());


    }
}
