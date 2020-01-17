pragma solidity ^0.5.0;

import "./ERC721MetadataMintable.sol";

contract GxCards is ERC721MetadataMintable {
    constructor (string memory name, string memory symbol, string memory baseURI) public
    ERC721Metadata(name, symbol)
    {
        _setBaseURI(baseURI);
    }

    function setBaseURI(string memory baseURI) public onlyMinter returns (bool) {
        _setBaseURI(baseURI);
        return true;
    }

    function mint(address to, uint256 tokenId) public onlyMinter returns (bool) {
        _mint(to, tokenId);
        return true;
    }

    function setTokenURI(uint256 tokenId, string memory _tokenURI) public onlyMinter returns (bool) {
        _setTokenURI(tokenId, _tokenURI);
        return true;
    }
}