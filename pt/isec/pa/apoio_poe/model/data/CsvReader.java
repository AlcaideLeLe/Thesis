package pt.isec.pa.apoio_poe.model.data;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CsvReader {
    public static void main(String[] args) throws Exception {
        long linhasAlunos = 0;
        Path caminho = Paths.get("pt/isec/pa/apoio_poe/model/data/Aluno.csv");
        linhasAlunos = Files.lines(caminho).count();
        ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
        ArrayList<Docente> listaDeDocentes = new ArrayList<>();
        ArrayList<String> arrayAluno = new ArrayList<>();
        ArrayList<String> arrayDocente = new ArrayList<>();
        Scanner scAluno = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Aluno.csv"));
        Scanner scDocente = new Scanner(new File("pt/isec/pa/apoio_poe/model/data/Docentes.csv"));
        //parsing a CSV file into the constructor of Scanner class
        scAluno.useDelimiter(";");
        scDocente.useDelimiter(";");
        //setting comma as delimiter pattern
        while (scAluno.hasNext()) {
            arrayAluno.add(scAluno.nextLine());
        }
        while (scDocente.hasNext()) {
            arrayDocente.add(scDocente.nextLine());
        }
        System.out.println(arrayAluno);
        System.out.println(arrayDocente);

        Aluno aluno = null;
        Docente docente = null;
        String[] dadosAluno;
        String[] dadosDocente;
        for(int i=0; i < arrayAluno.size() ; i++){
            dadosAluno = arrayAluno.get(i).split(";");
            listaDeAlunos.add(new Aluno(Long.parseLong(dadosAluno[0]), dadosAluno[1], dadosAluno[2],
                    dadosAluno[3], dadosAluno[4], Double.parseDouble(dadosAluno[5]),
                    Boolean.parseBoolean(dadosAluno[6])));
        }
        for(int i=0; i < arrayDocente.size() ; i++){
            dadosDocente = arrayDocente.get(i).split(";");
            listaDeDocentes.add(new Docente(dadosDocente[0], dadosDocente[1]));
        }
        Scanner resposta, scIndice;
        int indice;
        resposta = new Scanner(System.in);

        scIndice = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1 - Editar Aluno");
        System.out.println("2 - Consultar Aluno");
        System.out.println("3 - Remover aluno");

        switch(resposta.nextInt()) {
            case 1:
                System.out.println(arrayAluno);
                System.out.println("Insira o indice do aluno que quer editar?");
                indice = scIndice.nextInt();
                listaDeAlunos = listaDeAlunos.get(indice).editAluno(listaDeAlunos);
            case 2:
                // code block
            default:
                // code block
        }


        //que operaçao quer fazer
        //1-editar
        //2----
        //if 1
        //mostra a lista de alunos
        //pede ao utilizador para escolher o indice do aluno a alterar e guarda em x
        //




        scAluno.close();
        //closes the scanner
    }
}