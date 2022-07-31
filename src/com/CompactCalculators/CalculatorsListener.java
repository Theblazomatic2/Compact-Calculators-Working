package com.CompactCalculators;
import java.util.EventListener;
public interface CalculatorsListener extends EventListener{
	public void calcEventOccurred(CalculatorsEvent e);
}
