package blackjack.model.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AbstractListenableModel implements ListenableModel {
    
    private List<ModelListener> listeners;

    public AbstractListenableModel() {
        listeners = new ArrayList<ModelListener>();
    }

    @Override
    public void addModelListener(ModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeModelListener(ModelListener l) {
        listeners.remove(l);
    }

    protected void fireChange()
    {
        for (Iterator<ModelListener> it = listeners.iterator(); it.hasNext();) {
            ModelListener l = it.next();
            l.somethingHasChanged(this);
        }
    }
    
}
