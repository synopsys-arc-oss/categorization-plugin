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

import hudson.model.Descriptor;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 *
 * @author Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 */
public class CategoriesList implements Serializable {
    private List<CategoryType> items = new LinkedList<CategoryType>();

    /**
     *
     * @param items
     */
    @DataBoundConstructor
    public CategoriesList(CategoryType[] items) {
        
    }

    private CategoriesList() {}
    
    private void add(CategoryType type) {
        items.add(type);
    }

    public List<CategoryType> getItems() {
        return items;
    }
    
    public static CategoriesList Parse(StaplerRequest req, JSONObject form, String entryName)
            throws IOException, Descriptor.FormException
    {
        if (!form.containsKey(entryName)) {
            return null;
        }
        
        CategoriesList list = new CategoriesList();       
        JSONObject obj = form.optJSONObject(entryName);
        if (obj != null) {
            list.add(req.bindJSON(CategoryType.class, obj));
        }
        else {
            JSONArray array = form.getJSONArray(entryName);
            for (int i=0; i<array.size(); i++) {
                list.add(req.bindJSON(CategoryType.class, array.getJSONObject(i)));
            }
        }
        
        return list;
    }
}
