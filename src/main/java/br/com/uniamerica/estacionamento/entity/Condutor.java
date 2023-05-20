/* -------------------Package--------------------------- */
package br.com.uniamerica.estacionamento.entity;

/* -------------------Imports--------------------------- */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

/* ----------------------------------------------------- */
@Entity
@Audited
@Table(name = "condutores", schema = "public")
@AuditTable(value = "condutores_audit", schema = "audit")
public class Condutor extends AbstractEntity {

    @NotNull(message = "O nome do condutor não pode ser nulo.")
    @Size(min = 2, max = 40, message = "O nome do condutor deve ter no máximo 40 caracteres.")
    @NotBlank(message = "O nome do condutor não pode ser vazio.")
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    @CPF
    @Getter
    @Setter
    @Column(name = "cpf", nullable = false, unique = true, length = 15)
    private String cpf;

    @NotNull(message = "O telefone do condutor não pode ser nulo.")
    @Size(min = 0, max = 17, message = "O telefone do condutor deve ter no máximo 17 caracteres.")
    @NotBlank(message = "O telefone do condutor não pode ser vazio.")
    @Pattern(regexp = "\\+55\\(\\d{2}\\)\\d{9}", message = "O número de telefone fornecido não" +
            " está no formato válido. O formato deve seguir o padrão: +55(xx)xxxxxxxxx. " +
            "Por favor, corrija o número de telefone e tente novamente.")
    @Getter
    @Setter
    @Column(name = "telefone", nullable = false, length = 17)
    private String telefone;

    @Getter
    @Setter
    @Column(name = "tempohoras_gasto")
    private int tempoPagoHoras;

    @Getter
    @Setter
    @Column(name = "tempominutos_gasto")
    private int tempoPagoMinutos;

    @Getter
    @Setter
    @Column(name = "tempo_descontoHoras")
    private int tempoDescontoHoras;

}
