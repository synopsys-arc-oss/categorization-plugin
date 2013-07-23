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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 *
 * @author Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 */
public class ProjectsList implements Serializable {
    EntryMap entries;

    @DataBoundConstructor
    public ProjectsList(EntryMap entries) {
        this.entries = entries;
    }

    public EntryMap getEntries() {
        return entries;
    }
    
    public boolean hasEntries() {
        return entries != null;
    }
    
    public static class Entry implements Serializable {
        private String name;
        private String description;
        private String pageURL;
        private EntryMap entries;

        @DataBoundConstructor
        public Entry(String name, String description, String pageURL, EntryMap entries) {
            this.name = name;
            this.description = description;
            this.pageURL = pageURL;
            this.entries = entries;
        }

        public String getDescription() {
            return description;
        }

        public String getName() {
            return name;
        }

        public String getPageURL() {
            return pageURL;
        }

        public EntryMap getEntries() {
            return entries;
        }   
                
        public boolean hasEntries() {
            return entries != null;
        }
    }
    
    public static class EntryMap extends HashMap<String, Entry> implements Serializable {
        @DataBoundConstructor
        public EntryMap(Collection<Entry> entries) {
            for (Entry entry : entries) {
                put(entry.getName(), entry);
            }
        }
    }
}
