package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE5State extends apoio_poeAdapter{
    public FASE5State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE5;
    }
}