/**
 * Copyright (c) 2016 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.style;

import org.mini2Dx.core.exception.MdxException;
import org.mini2Dx.core.serialization.annotation.Field;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.utils.Array;

/**
 *
 */
public class TabStyleRule extends ColumnStyleRule {
	@Field
	private String buttonStyle;
	@Field
	private String menuStyle;
	@Field(optional=true)
	private String tabStyle;
	
	@Override
	public void validate(UiTheme theme) {
		super.validate(theme);
		if(!theme.containsButtonStyleRuleset(buttonStyle)) {
			throw new MdxException("No style with id '" + buttonStyle + "' for buttons. Required by " + TabStyleRule.class.getSimpleName());
		}
		if(!theme.containsColumnStyleRuleset(menuStyle)) {
			throw new MdxException("No style with id '" + menuStyle + "' for columns/rows. Required by " + TabStyleRule.class.getSimpleName());
		}
		if(tabStyle != null && !theme.containsColumnStyleRuleset(tabStyle)) {
			throw new MdxException("No style with id '" + tabStyle + "' for columns/rows. Required by " + TabStyleRule.class.getSimpleName());
		}
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}

	public String getMenuStyle() {
		return menuStyle;
	}

	public void setMenuStyle(String menuColumnStyle) {
		this.menuStyle = menuColumnStyle;
	}

	public String getTabStyle() {
		return tabStyle;
	}

	public void setTabStyle(String tabStyle) {
		this.tabStyle = tabStyle;
	}
}
