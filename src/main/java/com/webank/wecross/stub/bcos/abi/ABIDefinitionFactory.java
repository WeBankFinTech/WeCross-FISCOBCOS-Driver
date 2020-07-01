package com.webank.wecross.stub.bcos.abi;

import org.fisco.bcos.web3j.protocol.ObjectMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ABIDefinitionFactory {

    private static final Logger logger = LoggerFactory.getLogger(ABIDefinitionFactory.class);

    public static ContractABIDefinition create(String abi) {
        try {
            ABIDefinition[] abiDefinitions =
                    ObjectMapperFactory.getObjectMapper().readValue(abi, ABIDefinition[].class);

            ContractABIDefinition contractABIDefinition = new ContractABIDefinition();
            for (ABIDefinition abiDefinition : abiDefinitions) {
                if (abiDefinition.getType().equals("constructor")) {
                    contractABIDefinition.setConstructor(abiDefinition);
                } else if (abiDefinition.getType().equals("function")) {
                    contractABIDefinition.addFunction(abiDefinition.getName(), abiDefinition);
                } else if (abiDefinition.getType().equals("event")) {
                    contractABIDefinition.addEvent(abiDefinition.getName(), abiDefinition);
                }
                if (logger.isDebugEnabled()) {
                    logger.debug(" abiDefinition: {}", abiDefinition);
                }
            }

            logger.info(" ABI Definition, length: {}", abiDefinitions.length);
            return contractABIDefinition;

        } catch (Exception e) {
            logger.error(" e: ", e);
            return null;
        }
    }
}
