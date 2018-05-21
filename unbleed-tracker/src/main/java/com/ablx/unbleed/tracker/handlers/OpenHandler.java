package com.ablx.unbleed.tracker.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.ablx.unbleed.backend.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class OpenHandler {

	@Execute
	public void execute(Shell shell) {
		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/hello/" + "Xavier");

			ClientResponse response = webResource.get(ClientResponse.class);

		
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			
			ObjectMapper mapper = new ObjectMapper();

			

			// Convert JSON string from file to Object
			User staff = mapper.readValue(output, User.class);
			
System.out.println(staff.getName());

		} catch (Exception e) {

			// Handling errors
			System.err.println(e);
		}
		FileDialog dialog = new FileDialog(shell);
		dialog.open();
	}
}
