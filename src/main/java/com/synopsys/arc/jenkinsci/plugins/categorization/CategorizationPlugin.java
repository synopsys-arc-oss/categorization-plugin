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
package com.synopsys.arc.jenkinsci.plugins.categorization;

import com.synopsys.arc.jenkinsci.plugins.categorization.categories.CategoriesList;
import com.synopsys.arc.jenkinsci.plugins.categorization.categories.CategoryType;
import com.synopsys.arc.jenkinsci.plugins.categorization.categories.project.ProjectsList;
import hudson.Plugin;
import hudson.model.Descriptor;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Categorization plugin.
 * Plugin provides setup of categories for slaves and nodes.
 * Features:
 * TODO: Scheduling according to category (promote to labels?)
 * @author Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 */
public class CategorizationPlugin extends Plugin {
    private CategoriesList categories;
    private ProjectsList projectList;
    
    public CategoriesList getCategories() {
        return categories != null ? categories : CategoriesList.EMPTY_LIST;
    }

    public ProjectsList getProjectList() {
        return projectList;
    }

    public Collection<CategoryType> getCategoriesList() {
        return categories.getItems();
    }
    
    @Override
    public void configure(StaplerRequest req, JSONObject formData) throws IOException, ServletException, Descriptor.FormException {          
        categories = CategoriesList.Parse(req, formData, "Categories");
        save();
    } 
}
