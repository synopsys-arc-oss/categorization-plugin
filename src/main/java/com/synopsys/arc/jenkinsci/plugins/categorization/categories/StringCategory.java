/*
 * The MIT License
 *
 * Copyright 2013 Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.synopsys.arc.jenkinsci.plugins.categorization.categories;

import com.synopsys.arc.jenkinsci.plugins.categorization.Messages;
import hudson.Extension;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * String category.
 * @author Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 */
public class StringCategory extends CategoryType {
  
    private String defaultValue;

    @DataBoundConstructor
    public StringCategory(String name, String description, boolean mandatory, String defaultValue) {
        super(name, description, mandatory);
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
   
    @Extension
    public static class DescriptorImpl extends CategoryTypeDescriptor {        
        @Override
        public String getDisplayName() {
            return Messages.Categories_String_DisplayName();
        } 
    }  
}
