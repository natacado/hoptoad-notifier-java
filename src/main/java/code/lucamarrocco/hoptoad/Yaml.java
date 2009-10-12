// Modified or written by Luca Marrocco for inclusion with hoptoad.
// Copyright (c) 2009 Luca Marrocco.
// Licensed under the Apache License, Version 2.0 (the "License")

package code.lucamarrocco.hoptoad;

import java.util.*;

public class Yaml {

        private final Map<String, Object> map = new HashMap<String, Object>();

	public Yaml(final HoptoadNotice notice) {
                Map<String, Object> n = new HashMap<String, Object>();

                n.put("api_key", notice.apiKey());
                n.put("error_message", notice.errorMessage());
                n.put("error_class", notice.errorClass());
                n.put("request", new HashMap<String, Object>());
                n.put("session", notice.session());

                ArrayList<String> backtraces = new ArrayList<String>();
                for (final String backtrace : notice.backtrace()) {
                        backtraces.add(backtrace);
                }
                n.put("backtrace", backtraces);
                n.put("environment", notice.environment());

                map.put("notice", n);
	}

	@Override
	public String toString() {
                org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();
                return yaml.dump(map);
	}
}
