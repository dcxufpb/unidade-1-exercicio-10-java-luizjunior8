package com.example.project;

public class Loja {

    private String nomeLoja;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, String logradouro, int numero, String complemento, String bairro, String municipio,
            String estado, String cep, String telefone, String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCep() {
        return this.cep;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public static String Spacer = System.lineSeparator();

    public static boolean checker (String tested){
		String k = "";
		k += tested;
		if (k.equals("null")|| k.isEmpty()){
			return false;
		}	
		return true;	
    }
    
    public void valida_dados_obrigatorios() {

        if (checker(this.getNomeLoja()) == false){
			throw new RuntimeException ("O campo nome da loja é obrigatório");
		}

		if (checker(this.getLogradouro()) == false){
			throw new RuntimeException ("O campo logradouro do endereço é obrigatório");
        }
        
        if (checker(this.getMunicipio()) == false){
			throw new RuntimeException ("O campo município do endereço é obrigatório");			
        }

        if (checker(this.getEstado()) == false){
			throw new RuntimeException ("O campo estado do endereço é obrigatório");
        }
        
        if (checker(this.getCnpj()) == false){
			throw new RuntimeException ("O campo cnpj da loja é obrigatório");
        }
        
        if (checker(this.getInscricaoEstadual()) == false){
			throw new RuntimeException ("O campo inscrição estadual da loja é obrigatório");
		}
    }

    public String dadosLoja() {

		String _logradouro = this.getLogradouro()+ ", ";
		
		String _numero = "0";

		if (this.getNumero() == 0){
			_numero = "s/n";
		}else{
			_numero = String.format ("%d", this.getNumero());
		}

		String _complemento = (checker(this.getComplemento()) == false) ? "" : " " + this.getComplemento();

        String _bairro = checker(this.getBairro()) == false ? "" : this.getBairro() + " - ";
        
        String _municipio = this.getMunicipio() + " - ";

        String _cep = "";

		if (checker(this.getCep()) == true){
			_cep = "CEP:" + this.getCep();
		}

		String _telefone = checker(this.getTelefone()) == false? "" : "Tel " + this.getTelefone();

	 	if (!_cep.isEmpty() && !_telefone.isEmpty()){
			_telefone = " Tel " + this.getTelefone();
		}
		
        String _observacao = checker(this.getObservacao()) == false ? "" : this.getObservacao();
        
        String _cnpj = "CNPJ: " + this.getCnpj();

        String _inscricao_estadual = "IE: " + this.getInscricaoEstadual(); 

		return (this.getNomeLoja() + Spacer +
		 _logradouro + _numero + _complemento + Spacer +
		 _bairro + _municipio + this.getEstado() + Spacer +
		 _cep + _telefone + Spacer +
		 _observacao + Spacer +	
		 _cnpj + Spacer +
		 _inscricao_estadual + Spacer);
	}

}