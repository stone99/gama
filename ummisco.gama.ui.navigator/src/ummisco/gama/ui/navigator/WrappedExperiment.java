/*********************************************************************************************
 *
 * 'WrappedExperiment.java, in plugin ummisco.gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2016 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package ummisco.gama.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import msi.gama.runtime.GAMA;
import msi.gama.util.file.GamlFileInfo;
import ummisco.gama.ui.resources.GamaIcons;
import ummisco.gama.ui.resources.IGamaColors;

/**
 * Class WrappedExperiment.
 *
 * @author drogoul
 * @since 19 nov. 2014
 *
 */
public class WrappedExperiment extends WrappedGamlObject {

	private static String prefix = "Experiment ";
	final String internalName;
	final boolean isBatch;

	/**
	 * @param root
	 * @param object
	 */
	public WrappedExperiment(final IFile root, final String name) {
		super(root, prefix + name.replace(GamlFileInfo.BATCH_PREFIX, ""));
		isBatch = name.contains(GamlFileInfo.BATCH_PREFIX);
		internalName = name.replace(GamlFileInfo.BATCH_PREFIX, "");
	}

	@Override
	public Object[] getNavigatorChildren() {
		return EMPTY;
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	// @Override
	// public boolean isParentOf(final Object element) {
	// return false;
	// }

	@Override
	public Image getImage() {
		return GamaIcons.create(isBatch ? "gaml/_batch" : "gaml/_gui").image();

	}

	@Override
	public Color getColor() {
		return IGamaColors.BLACK.color();
	}

	@Override
	public boolean handleDoubleClick() {
		GAMA.getGui().runModel(getParent(), internalName);
		return true;
	}

}
