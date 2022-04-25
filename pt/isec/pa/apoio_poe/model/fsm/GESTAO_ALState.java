package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;

public class GESTAO_ALState extends apoio_poeAdapter{
    public GESTAO_ALState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_AL;
    }

    @Override
    public boolean changeFromGestaoALtoBase() {
        changeState(apoio_poeState.FASE1);
        return true;
    }
    @Override
    public void addAluno(){context.addAluno();}
    @Override
    public String consultaAluno(long nrAluno){return context.consultaAluno(nrAluno);}
    @Override
    public String consultaAlunos(){return context.consultaAlunos();}

}
