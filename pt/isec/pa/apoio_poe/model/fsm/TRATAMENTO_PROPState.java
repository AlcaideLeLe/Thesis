package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class TRATAMENTO_PROPState extends apoio_poeAdapter{
    public TRATAMENTO_PROPState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.TRATAMENTO_PROP;
    }
}
