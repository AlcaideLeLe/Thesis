package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

abstract class apoio_poeAdapter implements IApoio_poeState{
    apoio_poeContext context;
    PoE data;

    public apoio_poeAdapter(apoio_poeContext context, PoE data){
        this.context = context;
        this.data = data;
    }

    public void changeState(apoio_poeState state){
            context.changeState(state.createState(context, data));
    }

    @Override
    public void fecharFase() {}
    @Override
    public boolean avancarFase() {return false;}
    @Override
    public boolean recuarFase() {return false;}
    @Override
    public boolean changeToGestaoAL() {return false;}
    @Override
    public boolean changeToGestaoCAND(){return false;}
    @Override
    public boolean changeToGestaoDOC(){return false;}
    @Override
    public boolean changeToGestaoORI(){return false;}
    @Override
    public boolean changeToTratamentoProp() {return false;}
    @Override
    public boolean changeFromGestaoPROPtoBase() {return false;}
    @Override
    public boolean changeFromGestaoALtoBase() {return false;}
    @Override
    public boolean changeFromGestaoDOCtoBase() {return false;}
    @Override
    public boolean changeFromGestaoCANDtoBase() {return false;}
    @Override
    public boolean changeFromGestaoORItoBase() {return false;}
    @Override
    public boolean changeToGestaoManualAtribuicoesState() {return false;}
    @Override
    public boolean changeToGestaoDeDocentesState(){return false;}
    @Override
    public boolean changeFromGestaoManualAtribToFase3(){return false;}
    @Override
    public boolean changeFromGestaoManualOrientToFase4(){return false;}
    public boolean changeToPropState(){return false;}
    public boolean changeFromTratamentoPropToBase(){return false;}
    public boolean changeFromF3MasF2AbertaToBase(){return false;}
    public boolean changeToF3MasF2Aberta(){return false;}
    public boolean changeToFase1State(){return false;}
    public boolean loadState(){return false;}
    public boolean changeToFaseBloqueadaAnterior(){return false;}


    //Fase 1
    @Override
    public void addAluno(){};
    @Override
    public void addDocente(){};
    @Override
    public void addProposta(){};
    @Override
    public void exportarDocentesParaCSV(String nomeFicheiro){};
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){};
    @Override
    public void exportarPropostasParaCSV(String nomeFicheiro){};
    @Override
    public void exportarCandidaturasParaCSV(String nomeFicheiro){};
    @Override
    public String consultaAluno(long nrAluno) {return null;}
    @Override
    public String consultarAlunos() {return null;}
    @Override
    public String consultaDocente(String email){return null;}
    @Override
    public String consultaDocentes(){return null;}
    @Override
    public String consultaProposta(String idProposta){return null;}
    @Override
    public String consultaPropostas(){return null;}



    //Fase 2
    @Override
    public void addCandidatura(){};
    @Override
    public String consultaCandidatura(long nrAluno){return null;}
    @Override
    public String consultaCandidaturas(){return null;}
    @Override
    public String consultaAlunosComAutoproposta(){return null;}
    @Override
    public String consultarAlunosComCandidatura(){return null;};
    @Override
    public String consultarAlunosSemCandidatura(){return null;};
    @Override
    public String consultarListaDeAutopropostas(){return null;};
    @Override
    public String consultarPropostasDeDocentes(){return null;};
    @Override
    public String consultarPropostasComCandidaturas(){return null;};
    @Override
    public String consultarPropostasSemCandidaturas(){return null;};



    //Fase 3
    @Override
    public void atribuirAutoproposta(){};
    @Override
    public void atribuirPropostaDeDocente(){};
    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){};
    @Override
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){};
    @Override
    public void removerPropostaManualmente(long nrAluno){};
    @Override
    public String consultarAlunosComPropostaAtribuida(){return null;};
    @Override
    public String consultarAlunosSemPropostaAtribuida(){return null;};
    @Override
    public String consultarPropostasDisponiveis(){return null;};
    @Override
    public String consultarPropostasAtribuidas(){return null;};
    @Override
    public boolean changeToGestaoManualOrientState(){return false;}

    //Fase 4
    @Override
    public void atribuirPropostaADocenteProponenteAutomaticamente(){}
    @Override
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf){};
    @Override
    public String consultarOrientadorDeProposta(String idProposta){return null;};
    @Override
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){};
    @Override
    public void removerOrientadorDeProposta(String idProposta){};
    @Override
    public String consultarAlunosComPropostaEComOrientador(){return null;};
    @Override
    public String consultarAlunosComPropostaESemOrientador(){return null;};
    @Override
    public String consultarDocenteComMenosOrientacoes(){return null;};
    @Override
    public String consultarDocenteComMaisOrientacoes(){return null;};
    @Override
    public String consultarMediaDeOrientacoesDosDocentes(){return null;};





    //Fase 5
    @Override
    public String consultarAlunosComCandidaturaESemProposta(){return null;};
    public void removerTodasAsAtribuicoes(){}
    public String consultarPropostas(){return null;}
    public String consultarOrientacoesDocente(String email){return null;}







}
