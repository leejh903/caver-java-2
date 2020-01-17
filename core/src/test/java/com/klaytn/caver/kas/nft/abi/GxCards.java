package com.klaytn.caver.kas.nft.abi;

import com.klaytn.caver.Caver;
import com.klaytn.caver.crypto.KlayCredentials;
import com.klaytn.caver.methods.response.KlayLogs;
import com.klaytn.caver.methods.response.KlayTransactionReceipt;
import com.klaytn.caver.tx.SmartContract;
import com.klaytn.caver.tx.manager.TransactionManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated smart contract code.
 * <p><strong>Do not modify!</strong>
 */
public class GxCards extends SmartContract {
    private static final String BINARY = "60806040523480156200001157600080fd5b50604051620021c8380380620021c8833981018060405260608110156200003757600080fd5b8101908080516401000000008111156200005057600080fd5b820160208101848111156200006457600080fd5b81516401000000008111828201871017156200007f57600080fd5b505092919060200180516401000000008111156200009c57600080fd5b82016020810184811115620000b057600080fd5b8151640100000000811182820187101715620000cb57600080fd5b50509291906020018051640100000000811115620000e857600080fd5b82016020810184811115620000fc57600080fd5b81516401000000008111828201871017156200011757600080fd5b50509291905050508282620001396301ffc9a760e01b620001d160201b60201c565b620001516380ac58cd60e01b620001d160201b60201c565b81516200016690600590602085019062000437565b5080516200017c90600690602084019062000437565b5062000195635b5e139f60e01b620001d160201b60201c565b5050620001b7620001ab620002a060201b60201c565b620002a560201b60201c565b620001c881620002f760201b60201c565b505050620004d9565b7fffffffff0000000000000000000000000000000000000000000000000000000080821614156200026357604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601c60248201527f4552433136353a20696e76616c696420696e7465726661636520696400000000604482015290519081900360640190fd5b7fffffffff00000000000000000000000000000000000000000000000000000000166000908152602081905260409020805460ff19166001179055565b335b90565b620002c08160096200031060201b620016131790919060201c565b6040516001600160a01b038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b80516200030c90600790602084019062000437565b5050565b620003228282620003b460201b60201c565b156200038f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601f60248201527f526f6c65733a206163636f756e7420616c72656164792068617320726f6c6500604482015290519081900360640190fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b03821662000417576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180620021a66022913960400191505060405180910390fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200047a57805160ff1916838001178555620004aa565b82800160010185558215620004aa579182015b82811115620004aa5782518255916020019190600101906200048d565b50620004b8929150620004bc565b5090565b620002a291905b80821115620004b85760008155600101620004c3565b611cbd80620004e96000396000f3fe608060405234801561001057600080fd5b50600436106101375760003560e01c80636352211e116100b8578063986502751161007c5780639865027514610586578063a22cb4651461058e578063aa271e1a146105bc578063b88d4fde146105e2578063c87b56dd146106a6578063e985e9c5146106c357610137565b80636352211e146104fb5780636c0360eb1461051857806370a082311461052057806395d89b4114610558578063983b2d561461056057610137565b806323b872dd116100ff57806323b872dd1461030657806340c10f191461033c57806342842e0e1461036857806350bb4e7f1461039e57806355f804b31461045757610137565b806301ffc9a71461013c57806306fdde0314610177578063081812fc146101f4578063095ea7b31461022d578063162094c41461025b575b600080fd5b6101636004803603602081101561015257600080fd5b50356001600160e01b0319166106f1565b604080519115158252519081900360200190f35b61017f610714565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101b95781810151838201526020016101a1565b50505050905090810190601f1680156101e65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6102116004803603602081101561020a57600080fd5b50356107ab565b604080516001600160a01b039092168252519081900360200190f35b6102596004803603604081101561024357600080fd5b506001600160a01b038135169060200135610810565b005b6101636004803603604081101561027157600080fd5b81359190810190604081016020820135600160201b81111561029257600080fd5b8201836020820111156102a457600080fd5b803590602001918460018302840111600160201b831117156102c557600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061093e945050505050565b6102596004803603606081101561031c57600080fd5b506001600160a01b038135811691602081013590911690604001356109a1565b6101636004803603604081101561035257600080fd5b506001600160a01b038135169060200135610a00565b6102596004803603606081101561037e57600080fd5b506001600160a01b03813581169160208101359091169060400135610a55565b610163600480360360608110156103b457600080fd5b6001600160a01b0382351691602081013591810190606081016040820135600160201b8111156103e357600080fd5b8201836020820111156103f557600080fd5b803590602001918460018302840111600160201b8311171561041657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610a70945050505050565b6101636004803603602081101561046d57600080fd5b810190602081018135600160201b81111561048757600080fd5b82018360208201111561049957600080fd5b803590602001918460018302840111600160201b831117156104ba57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610ad9945050505050565b6102116004803603602081101561051157600080fd5b5035610b35565b61017f610b92565b6105466004803603602081101561053657600080fd5b50356001600160a01b0316610bf3565b60408051918252519081900360200190f35b61017f610c5e565b6102596004803603602081101561057657600080fd5b50356001600160a01b0316610cbf565b610259610d14565b610259600480360360408110156105a457600080fd5b506001600160a01b0381351690602001351515610d26565b610163600480360360208110156105d257600080fd5b50356001600160a01b0316610e2e565b610259600480360360808110156105f857600080fd5b6001600160a01b03823581169260208101359091169160408201359190810190608081016060820135600160201b81111561063257600080fd5b82018360208201111561064457600080fd5b803590602001918460018302840111600160201b8311171561066557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610e41945050505050565b61017f600480360360208110156106bc57600080fd5b5035610ea2565b610163600480360360408110156106d957600080fd5b506001600160a01b0381358116916020013516611071565b6001600160e01b0319811660009081526020819052604090205460ff165b919050565b60058054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156107a05780601f10610775576101008083540402835291602001916107a0565b820191906000526020600020905b81548152906001019060200180831161078357829003601f168201915b505050505090505b90565b60006107b68261109f565b6107f457604051600160e51b62461bcd02815260040180806020018281038252602c815260200180611b6e602c913960400191505060405180910390fd5b506000908152600260205260409020546001600160a01b031690565b600061081b82610b35565b9050806001600160a01b0316836001600160a01b0316141561087157604051600160e51b62461bcd028152600401808060200182810382526021815260200180611c406021913960400191505060405180910390fd5b806001600160a01b03166108836110bc565b6001600160a01b031614806108a457506108a48161089f6110bc565b611071565b6108e257604051600160e51b62461bcd028152600401808060200182810382526038815260200180611a926038913960400191505060405180910390fd5b60008281526002602052604080822080546001600160a01b0319166001600160a01b0387811691821790925591518593918516917f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591a4505050565b600061095061094b6110bc565b610e2e565b61098e57604051600160e51b62461bcd028152600401808060200182810382526030815260200180611b1d6030913960400191505060405180910390fd5b61099883836110c0565b50600192915050565b6109b26109ac6110bc565b82611126565b6109f057604051600160e51b62461bcd028152600401808060200182810382526031815260200180611c616031913960400191505060405180910390fd5b6109fb8383836111cd565b505050565b6000610a0d61094b6110bc565b610a4b57604051600160e51b62461bcd028152600401808060200182810382526030815260200180611b1d6030913960400191505060405180910390fd5b6109988383611317565b6109fb83838360405180602001604052806000815250610e41565b6000610a7d61094b6110bc565b610abb57604051600160e51b62461bcd028152600401808060200182810382526030815260200180611b1d6030913960400191505060405180910390fd5b610ac58484611317565b610acf83836110c0565b5060019392505050565b6000610ae661094b6110bc565b610b2457604051600160e51b62461bcd028152600401808060200182810382526030815260200180611b1d6030913960400191505060405180910390fd5b610b2d8261144e565b506001919050565b6000818152600160205260408120546001600160a01b031680610b8c57604051600160e51b62461bcd028152600401808060200182810382526029815260200180611af46029913960400191505060405180910390fd5b92915050565b60078054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156107a05780601f10610775576101008083540402835291602001916107a0565b60006001600160a01b038216610c3d57604051600160e51b62461bcd02815260040180806020018281038252602a815260200180611aca602a913960400191505060405180910390fd5b6001600160a01b0382166000908152600360205260409020610b8c90611465565b60068054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156107a05780601f10610775576101008083540402835291602001916107a0565b610cca61094b6110bc565b610d0857604051600160e51b62461bcd028152600401808060200182810382526030815260200180611b1d6030913960400191505060405180910390fd5b610d1181611469565b50565b610d24610d1f6110bc565b6114b1565b565b610d2e6110bc565b6001600160a01b0316826001600160a01b03161415610d975760408051600160e51b62461bcd02815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c657200000000000000604482015290519081900360640190fd5b8060046000610da46110bc565b6001600160a01b03908116825260208083019390935260409182016000908120918716808252919093529120805460ff191692151592909217909155610de86110bc565b60408051841515815290516001600160a01b0392909216917f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c319181900360200190a35050565b6000610b8c60098363ffffffff6114f916565b610e52610e4c6110bc565b83611126565b610e9057604051600160e51b62461bcd028152600401808060200182810382526031815260200180611c616031913960400191505060405180910390fd5b610e9c84848484611563565b50505050565b6060610ead8261109f565b610eeb57604051600160e51b62461bcd02815260040180806020018281038252602f815260200180611c11602f913960400191505060405180910390fd5b60008281526008602090815260409182902080548351601f6002600019610100600186161502019093169290920491820184900484028101840190945280845260609392830182828015610f805780601f10610f5557610100808354040283529160200191610f80565b820191906000526020600020905b815481529060010190602001808311610f6357829003601f168201915b50505050509050805160001415610fa757505060408051602081019091526000815261070f565b60078160405160200180838054600181600116156101000203166002900480156110085780601f10610fe6576101008083540402835291820191611008565b820191906000526020600020905b815481529060010190602001808311610ff4575b5050825160208401908083835b602083106110345780518252601f199092019160209182019101611015565b6001836020036101000a0380198251168184511680821785525050505050509050019250505060405160208183030381529060405291505061070f565b6001600160a01b03918216600090815260046020908152604080832093909416825291909152205460ff1690565b6000908152600160205260409020546001600160a01b0316151590565b3390565b6110c98261109f565b61110757604051600160e51b62461bcd02815260040180806020018281038252602c815260200180611b9a602c913960400191505060405180910390fd5b600082815260086020908152604090912082516109fb92840190611977565b60006111318261109f565b61116f57604051600160e51b62461bcd02815260040180806020018281038252602c815260200180611a66602c913960400191505060405180910390fd5b600061117a83610b35565b9050806001600160a01b0316846001600160a01b031614806111b55750836001600160a01b03166111aa846107ab565b6001600160a01b0316145b806111c557506111c58185611071565b949350505050565b826001600160a01b03166111e082610b35565b6001600160a01b03161461122857604051600160e51b62461bcd028152600401808060200182810382526029815260200180611be86029913960400191505060405180910390fd5b6001600160a01b03821661127057604051600160e51b62461bcd028152600401808060200182810382526024815260200180611a426024913960400191505060405180910390fd5b611279816115b8565b6001600160a01b038316600090815260036020526040902061129a906115f3565b6001600160a01b03821660009081526003602052604090206112bb9061160a565b60008181526001602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b6001600160a01b0382166113755760408051600160e51b62461bcd02815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604482015290519081900360640190fd5b61137e8161109f565b156113d35760408051600160e51b62461bcd02815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e74656400000000604482015290519081900360640190fd5b600081815260016020908152604080832080546001600160a01b0319166001600160a01b0387169081179091558352600390915290206114129061160a565b60405181906001600160a01b038416906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b8051611461906007906020840190611977565b5050565b5490565b61147a60098263ffffffff61161316565b6040516001600160a01b038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b6114c260098263ffffffff61169716565b6040516001600160a01b038216907fe94479a9f7e1952cc78f2d6baab678adc1b772d936c6583def489e524cb6669290600090a250565b60006001600160a01b03821661154357604051600160e51b62461bcd028152600401808060200182810382526022815260200180611bc66022913960400191505060405180910390fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b61156e8484846111cd565b61157a84848484611701565b610e9c57604051600160e51b62461bcd028152600401808060200182810382526032815260200180611a106032913960400191505060405180910390fd5b6000818152600260205260409020546001600160a01b031615610d1157600090815260026020526040902080546001600160a01b0319169055565b805461160690600163ffffffff61185b16565b9055565b80546001019055565b61161d82826114f9565b156116725760408051600160e51b62461bcd02815260206004820152601f60248201527f526f6c65733a206163636f756e7420616c72656164792068617320726f6c6500604482015290519081900360640190fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b6116a182826114f9565b6116df57604051600160e51b62461bcd028152600401808060200182810382526021815260200180611b4d6021913960400191505060405180910390fd5b6001600160a01b0316600090815260209190915260409020805460ff19169055565b6000611715846001600160a01b03166118a4565b611721575060016111c5565b6000846001600160a01b031663150b7a0261173a6110bc565b8887876040518563ffffffff1660e01b815260040180856001600160a01b03166001600160a01b03168152602001846001600160a01b03166001600160a01b0316815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156117bf5781810151838201526020016117a7565b50505050905090810190601f1680156117ec5780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b15801561180e57600080fd5b505af1158015611822573d6000803e3d6000fd5b505050506040513d602081101561183857600080fd5b50516001600160e01b031916600160e11b630a85bd010214915050949350505050565b600061189d83836040518060400160405280601e81526020017f536166654d6174683a207375627472616374696f6e206f766572666c6f7700008152506118dd565b9392505050565b6000813f7fc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a4708181148015906111c5575050151592915050565b6000818484111561196f57604051600160e51b62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b8381101561193457818101518382015260200161191c565b50505050905090810190601f1680156119615780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b505050900390565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106119b857805160ff19168380011785556119e5565b828001600101855582156119e5579182015b828111156119e55782518255916020019190600101906119ca565b506119f19291506119f5565b5090565b6107a891905b808211156119f157600081556001016119fb56fe4552433732313a207472616e7366657220746f206e6f6e20455243373231526563656976657220696d706c656d656e7465724552433732313a207472616e7366657220746f20746865207a65726f20616464726573734552433732313a206f70657261746f7220717565727920666f72206e6f6e6578697374656e7420746f6b656e4552433732313a20617070726f76652063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f76656420666f7220616c6c4552433732313a2062616c616e636520717565727920666f7220746865207a65726f20616464726573734552433732313a206f776e657220717565727920666f72206e6f6e6578697374656e7420746f6b656e4d696e746572526f6c653a2063616c6c657220646f6573206e6f74206861766520746865204d696e74657220726f6c65526f6c65733a206163636f756e7420646f6573206e6f74206861766520726f6c654552433732313a20617070726f76656420717565727920666f72206e6f6e6578697374656e7420746f6b656e4552433732314d657461646174613a2055524920736574206f66206e6f6e6578697374656e7420746f6b656e526f6c65733a206163636f756e7420697320746865207a65726f20616464726573734552433732313a207472616e73666572206f6620746f6b656e2074686174206973206e6f74206f776e4552433732314d657461646174613a2055524920717565727920666f72206e6f6e6578697374656e7420746f6b656e4552433732313a20617070726f76616c20746f2063757272656e74206f776e65724552433732313a207472616e736665722063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f766564a165627a7a72305820fc938004411d66319c581215551692e3a151d387947a944e046ac4aee18bb0850029526f6c65733a206163636f756e7420697320746865207a65726f2061646472657373";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_SETTOKENURI = "setTokenURI";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_MINTWITHTOKENURI = "mintWithTokenURI";

    public static final String FUNC_SETBASEURI = "setBaseURI";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_BASEURI = "baseURI";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_ADDMINTER = "addMinter";

    public static final String FUNC_RENOUNCEMINTER = "renounceMinter";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_ISMINTER = "isMinter";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final Event MINTERADDED_EVENT = new Event("MinterAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event MINTERREMOVED_EVENT = new Event("MinterRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    protected GxCards(String contractAddress, Caver caver, KlayCredentials credentials, int chainId, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, caver, credentials, chainId, contractGasProvider);
    }

    protected GxCards(String contractAddress, Caver caver, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, caver, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getApproved(BigInteger tokenId) {
        final Function function = new Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> approve(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> setTokenURI(BigInteger tokenId, String _tokenURI) {
        final Function function = new Function(
                FUNC_SETTOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.Utf8String(_tokenURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> mint(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> mintWithTokenURI(String to, BigInteger tokenId, String tokenURI) {
        final Function function = new Function(
                FUNC_MINTWITHTOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.Utf8String(tokenURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> setBaseURI(String baseURI) {
        final Function function = new Function(
                FUNC_SETBASEURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> ownerOf(BigInteger tokenId) {
        final Function function = new Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> baseURI() {
        final Function function = new Function(FUNC_BASEURI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> balanceOf(String owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> addMinter(String account) {
        final Function function = new Function(
                FUNC_ADDMINTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> renounceMinter() {
        final Function function = new Function(
                FUNC_RENOUNCEMINTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> setApprovalForAll(String to, Boolean approved) {
        final Function function = new Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isMinter(String account) {
        final Function function = new Function(FUNC_ISMINTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<KlayTransactionReceipt.TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> tokenURI(BigInteger tokenId) {
        final Function function = new Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isApprovedForAll(String owner, String operator) {
        final Function function = new Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public List<MinterAddedEventResponse> getMinterAddedEvents(KlayTransactionReceipt.TransactionReceipt transactionReceipt) {
        List<SmartContract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTERADDED_EVENT, transactionReceipt);
        ArrayList<MinterAddedEventResponse> responses = new ArrayList<MinterAddedEventResponse>(valueList.size());
        for (SmartContract.EventValuesWithLog eventValues : valueList) {
            MinterAddedEventResponse typedResponse = new MinterAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public List<MinterRemovedEventResponse> getMinterRemovedEvents(KlayTransactionReceipt.TransactionReceipt transactionReceipt) {
        List<SmartContract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTERREMOVED_EVENT, transactionReceipt);
        ArrayList<MinterRemovedEventResponse> responses = new ArrayList<MinterRemovedEventResponse>(valueList.size());
        for (SmartContract.EventValuesWithLog eventValues : valueList) {
            MinterRemovedEventResponse typedResponse = new MinterRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public List<TransferEventResponse> getTransferEvents(KlayTransactionReceipt.TransactionReceipt transactionReceipt) {
        List<SmartContract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (SmartContract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public List<ApprovalEventResponse> getApprovalEvents(KlayTransactionReceipt.TransactionReceipt transactionReceipt) {
        List<SmartContract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (SmartContract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(KlayTransactionReceipt.TransactionReceipt transactionReceipt) {
        List<SmartContract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (SmartContract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static GxCards load(String contractAddress, Caver caver, KlayCredentials credentials, int chainId, ContractGasProvider contractGasProvider) {
        return new GxCards(contractAddress, caver, credentials, chainId, contractGasProvider);
    }

    public static GxCards load(String contractAddress, Caver caver, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new GxCards(contractAddress, caver, transactionManager, contractGasProvider);
    }

    public static RemoteCall<GxCards> deploy(Caver caver, KlayCredentials credentials, int chainId, ContractGasProvider contractGasProvider, String name, String symbol, String baseURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Utf8String(baseURI)));
        return deployRemoteCall(GxCards.class, caver, credentials, chainId, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<GxCards> deploy(Caver caver, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String symbol, String baseURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Utf8String(baseURI)));
        return deployRemoteCall(GxCards.class, caver, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    public static class MinterAddedEventResponse {
        public KlayLogs.Log log;

        public String account;
    }

    public static class MinterRemovedEventResponse {
        public KlayLogs.Log log;

        public String account;
    }

    public static class TransferEventResponse {
        public KlayLogs.Log log;

        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class ApprovalEventResponse {
        public KlayLogs.Log log;

        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse {
        public KlayLogs.Log log;

        public String owner;

        public String operator;

        public Boolean approved;
    }
}
