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
package com.synopsys.arc.jenkinsci.plugins.categorization.categories.project;

import hudson.Extension;
import hudson.model.Failure;
import java.io.Serializable;
import jenkins.model.ProjectNamingStrategy;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Implements naming strategy, which checks first name sections according to list of available projects.
 * @author Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 */
public final class ProjectCategoryNamingStrategy 
    extends ProjectNamingStrategy implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private boolean forceExistingJobs;

    @DataBoundConstructor
    public ProjectCategoryNamingStrategy(boolean forceExistingJobs) {
        this.forceExistingJobs = forceExistingJobs;
    }
    
    @Override
    public void checkName(String name) throws Failure {
        super.checkName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isForceExistingJobs() {
        return forceExistingJobs;
    }
   
    @Extension
    public static final class DescriptorImpl extends ProjectNamingStrategyDescriptor {
        @Override
        public String getDisplayName() {
            return "Restrict naming according to projects";
        }       

        @Override
        public ProjectCategoryNamingStrategy newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            return (ProjectCategoryNamingStrategy)super.newInstance(req, formData); 
        }       
    }
}
